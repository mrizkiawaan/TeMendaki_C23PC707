import os
import json
import numpy as np
from keras.models import load_model
import requests
import tensorflow as tf
from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route("/predict/<string:id>", methods=["GET"])
def predict(id):
    user_id = id
    response = requests.get(f'https://backend-dot-temendaki-test.et.r.appspot.com/users/{user_id}')
    user_data = json.loads(response.text)
    value = np.expand_dims(user_data['experience_level'], axis=0)
    print("Experience level:", user_data['experience_level'])
    
    model = load_model('./model_keahllian')
    
    prediction = model.predict(value)
    
    sorted_indices = np.argsort(prediction)[::-1]
    
    responseMountain = requests.get(f'https://backend-dot-temendaki-test.et.r.appspot.com/pendakian')
    mountain_data = json.loads(responseMountain.text)
    
    recommendations = [mountain_data[int(index[0])]['climb_name'] for index in sorted_indices]
    
    result = {'recommendations': recommendations}
    return jsonify(result)
    
    

if __name__ == '__main__':
    app.run(debug=True)