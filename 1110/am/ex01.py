'''
[프로젝트명]
        ---flaskApp명
                ---static(요청시 바로 해석되어 응답이 가능한 파일)
                        ---css
                        ---images
            ---js
                ---templates(view페이지-HTML)
                ---__init__py
        ---start_flask.py(서버 구동시키는 것)
'''
from flask import Flask, g
# g는 Global Object로 인식된다. 서블릿의 ServletContext와 같은 객체다. 
    # (자바에서)현재 프로젝트를 아울러서 객체화시킨 것이 ServletContext임

app = Flask(__name__)

@app.before_request
def before_request():
    g.msg = 'g에 저장된 값'

# 요청하면 수행하는 함수
@app.route("/test2")

def test2():
    return "Nice to meet you :)"+ getattr(g, 'msg')