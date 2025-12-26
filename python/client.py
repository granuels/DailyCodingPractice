import requests
import time

SERVER_URL= "http://127.0.0.1:5000"
RECEIVER_URL="http://127.0.0.1:5001/my-callback-endpoint"
TOKEN="hr-secret-token"



def run_simulation():
    print("----1. REGISTERING WEBHOOK ---")

    try:
        resp= requests.post(f"{SERVER_URL}/webhooks", json={"url": RECEIVER_URL})
        print(f"Registration Status: {resp.status_code}")
    except Exception as e:
        print(f"CRITICAL ERROR: Is server.py running? {e}")
        return
    
    print("\n -- 2. CREATING CANDIATE --- ")
    headers={"Authorization": f"Bearer {TOKEN}"}
    payload={"name":"aNKU"}

    try:
        resp = requests.post(f"{SERVER_URL}/candidates", json=payload, headers=headers)
        if resp.status_code ==201:
            print("Success! Client received 201. Created")
            print(f"Received Body: {resp.json()}")

        else:
            print(f"Failed Status: {resp.status_code}")
            print(f"Error Message: {resp.text}")
    except Exception as e:
        print(f"Request Failed: {e}")


if __name__=='__main__':
    run_simulation()