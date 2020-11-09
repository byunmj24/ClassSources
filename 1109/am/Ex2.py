'''
  파이썬이 제공하는 여러 가지 모듈들
      - date : 날짜 관련 모듈
      - time : 시간 관련 모듈
      - math : 수학 관련 모듈
      - fractions : 분수 관련 모듈
      - decimal : 십진수 관련 모듈
      - random : 난수 관련 모듈
      - file : 파일 관련 모듈
      - os : 운영체제 관련 모듈
      - sys : 파이썬 번역기 관련 모듈
      - threading : 스레드 관련 모듈
      - xml : xml 문서 파싱 관련 모듈
      - http : http 프로토콜 관련 모듈
      - unittest : 단위 테스트 관련 모듈
      - sqlite3 : 데이터베이스 관련 모듈
      
      이 외에 약 2백여 개의 모듈들이 제공되고 있다.
      알아서 찾아보기
'''

import math
from datetime import date, datetime

v1 = 131.23

v2 = math.ceil(v1) #소수점을 잘라내면서 올림한 정수를 만들어 낸다.
print('math.ceil(v1):{}'.format(v2))

print('오늘:', date.today()) #오늘 날짜
print('현재:', datetime.now()) #오늘 날짜와 시간

