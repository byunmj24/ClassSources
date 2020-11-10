# 모듈 생성시 항상 만들어지는 파일.
# 해당 패키지를 대표하여 초기화시킬 수 있는 기본적인 파일. 
# 해당 모듈에 대해 알려주는 기본 파일임. 
from flask import Flask

app = Flask(__name__) # 상수격 인자를 넣어준다. 

# 스프링에서 함수 호출하기 위해 @RequestMapping했던 것과 동일
@app.route("/test")
def test():
    return "<h1>Hello Flask!</h1>"