from flask import Flask, request, jsonify
import requests
import threading
import time

app= Flask(__name__)
candidates=[]
webhook_url=None
API_TOKEN= "hr-secret-token"

def check_auth(headers):
    token= headers.get('Authorization')
    if token == f"Bearer {API_TOKEN}":
        return True
    return False

@app.route('/candidates', methods=['POST'])
def create_candidate():
    if not check_auth(request.headers):
        return jsonify({"error": "Unauthorized"}), 401
    

    data= request.get_json()
    if not data or 'name' not in data:
        return jsonify({"error": "Missing 'name'"}), 400
    
    new_user= {"id": len(candidates)+1, "name": data['name']}
    candidates.append(new_user)
    print(f"[SERVER] Created Candidate: {new_user['name']}")

    if webhook_url:
        def send_hook():
            try:
                print(f"[SERVER] sending webhook to {webhook_url}...")
                resp= requests.post(webhook_url, json={"event": "new_candidate", "data": new_user}, timeout=5)
                print(f"[SERVER] Webhook Status: {resp.status_code}")
            except Exception as e:
                print(f"[SERVER] Webhook Failed: {e}")

        threading.Thread(target=send_hook).start()
    return jsonify(new_user), 201


@app.route('/webhooks', methods=['POST'])
def register_webhook():
    global webhook_url
    data= request.get_json()
    webhook_url = data.get("url")
    print(f"[SERVER] Webhook URL set to: {webhook_url}")
    return jsonify({"msg": "Registered"}), 200


if __name__ == '__main__':
    print("--- API SERVER RUNNING ON PORT 5000 ---")
    app.run(port=5000)

