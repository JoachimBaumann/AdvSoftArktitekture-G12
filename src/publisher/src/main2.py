import paho.mqtt.client as mqtt
import random
import time

# MQTT broker settings
broker_address = "mosquitto"  # Change this to your MQTT broker's address
port = 1883
topic = "random_number"

# Create an MQTT client
client = mqtt.Client()

# Connect to the broker
client.connect(broker_address, port)

try:
    while True:
        # Generate a random number from 1 to 10
        random_number = random.randint(1, 10)

        # Publish the random number to the MQTT topic
        client.publish(topic, str(random_number))

        # Print the published number for reference
        print(f"Published: {random_number}")

        # Wait for one second before publishing the next number
        time.sleep(1)

except KeyboardInterrupt:
    # Gracefully exit the script on Ctrl+C
    print("Script terminated.")
    client.disconnect()