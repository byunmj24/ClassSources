from flask import Flask, jsonify
from flask_cors import CORS
from urllib.request import urlopen
import xml.etree.ElementTree as ET
from pandas.core.frame import DataFrame

app = Flask(__name__)
CORS(app)

spec = "http://open.ev.or.kr:8080/openapi/services/EvCharger/getChargerInfo?ServiceKey=FDp2a3vCnN%2BVvgfwp%2BneIQPvN3zTM7aLpEznSGbkyDN47qXAmtPene0L3A8mgUsbO%2F7pzLR3EX7rdD0%2B6wZe3Q%3D%3D"

@app.route('/')
def hello_world():
    str = '''
        <h1>Hello World</h1>
    '''
    return jsonify(code=str)
# {"code": "<h1>Hello World</h1>"}
# 여기서 code는 key가 되고 str이 value가 된다.
# 홑따옴표 세 개는 그냥 문자열을 의미. 그냥 홑따옴표 하나씩으로 써도 괜찮다.

@app.route("/evCar", methods=['Post'])
def ev_car():
    res = urlopen(spec)
    xmlDoc = ET.fromstring(res)
    
    items = xmlDoc.find('body').find('items')
    # body안에 있는 items는 item을 여러개 가지고 있는 List 구조다.
    
    rows = []
    for node in items:
        statNm = node.find('statNm').text
        addr = node.find('addr').add_text()
        rows.append({'s_name':statNm, 'addr':addr})
        
    df = DataFrame(rows)
    
    # DataFrame의 내용을 JSON으로 변환
    json = df.to_json(orient='records')
    
    return json