str = "go for it!"
print("str:%s"%str)
print("str:{}".format(str)) #위와 같다.

msg = str*3 #str이 기억하는 문자열을 1번 반복해서 변수 msg에 저장
print("str*3:%s"%msg)

msg2 = msg.replace("for", "4") #msg에서 "for"라는 문자열을 모두 찾아서 "4"로 변경하여
                                #msg2에다가 저장한다.
print("msg2:{}".format(msg2))

ar1 = str[3] # str의 4번째 문자를 가져와서 ar1에 저장 : f
print("str[3]:%s"%ar1)

ar2 = str[3:6] # str의 4번째 문자부터 7번째를 만나기 전까지 : for
print("str[3:6]:%s"%ar2)

idx = str.find("fo") # str에서 "fo"의 위치값을 찾아 변수 idx에 저장 : 3 / 같은 것이 없어서 찾지못하면 -1을 반환
print('str.find("fo"):{}'.format(idx))
print("str.find(\"fo\"):{}".format(idx))

