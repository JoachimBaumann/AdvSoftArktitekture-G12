import paho.mqtt.client as mqtt
import sys
import random
import time
from datetime import datetime
import json


# MQTT broker settings
broker_address = "mosquitto-service"  # Change this to your MQTT broker's address
port = 1883
topic = "random_number"


currentTime = datetime.now()
# Create an MQTT client
client = mqtt.Client()

# Connect to the broker
client.connect(broker_address, port)

sensorid = random.randint(1,100)

try:
    while True:
        now = datetime.now() # current date and time
        # Generate a random number from 1 to 10
        random_number = random.randint(1, 10)

        payload = {"sensorID": sensorid, "timestamp": now.strftime("%m/%d/%Y, %H:%M:%S"), "sensorData": random_number}
        payload2 = json.dumps(payload)
        

        # Publish the random number to the MQTT topic
        client.publish(topic, payload2)

        # Print the published number for reference
        print(f"Published: {payload}")
        

        sys.stdout.write(f"Published: {payload}")

        # Wait for one second before publishing the next number
        time.sleep(1)

except KeyboardInterrupt:
    # Gracefully exit the script on Ctrl+C
    print("Script terminated.")
    client.disconnect()