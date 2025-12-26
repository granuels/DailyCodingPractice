from flask import Flask, request, jsonify
app=Flask(__name__)



@app.route('/my-callback-endpoint', methods=['POST'])
def handle_webhook():
    print("\n--- WEBHOOK RECEIVED! ---")
    data=request.get_json()
    print(f"Event type: {data.get('event')}")
    candidate_name = data.get('data', {}).get('name')

    return jsonify({"status": "received"}), 200


if __name__=='__main__':
    print("--- RECEIVER RUNNING ON PORT 5001 ---")
    app.run(port=5001)
