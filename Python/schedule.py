# -*- coding: utf-8 -*- 

from datetime import date
from datetime import datetime

def Finals():
    
    finalsDate = 0;
    nowDate = date.today()
    remainingTime = str(finalsDate - nowDate)
    
    dating = remainingTime.split(' ');

    return dating

exam = Finals()
print (exam[0]+"일 남았습니다!")