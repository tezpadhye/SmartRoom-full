import pickle
import pandas as pd
import numpy as np
from pathlib import Path

BASE_DIR = Path(__file__).resolve(strict=True).parent

with open(f"{BASE_DIR}/trained_RFregsr.pkl", "rb") as f:
    model = pickle.load(f)

colus = ['sex', 'age', 'address', 'famsize', 'Pstatus', 'Medu', 'Fedu',
 'Mjob', 'Fjob', 'traveltime', 'studytime', 'failures', 'schoolsup', 'famsup',
 'paid', 'activities', 'nursery', 'higher', 'internet', 'famrel', 'freetime',
 'health', 'absences', 'G1', 'G2']

def predict_pipeline(params):
    params = pd.DataFrame([params], columns= colus)
    pred = model.predict(params)
    pred =  np.round(pred,0)
    pred=pred*5
    return int(pred)
