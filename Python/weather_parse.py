# -*- coding: utf-8 -*-

import requests
import re

url = 'http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108'
recvd = requests.get(url)

def findData():
    
    locations = re.findall(r'<location wl_ver="3">.+?</location>', recvd.text, re.DOTALL)
    
    for loc in locations:
        prov = re.findall(r'<province(.+)</province>', loc)
        city = re.findall(r'<city>(.+)</city>', loc)
        data = re.findall(r'<data>(.+)</data>', loc, re.DOTALL)

        for datum in data:
             mode = re.findall(r'<mode>(.+?)</mode>', datum)
             tmEf = re.findall(r'<tmEf>(.+?)</tmEf>', datum)
             wf   = re.findall(r'<wf>(.+?)</wf>', datum)
             tmn  = re.findall(r'<tmn>(.+?)</tmn>', datum)
             tmx  = re.findall(r'<tmx>(.+?)</tmx>', datum)
             reli = re.findall(r'<reliability>(.+?)</reliability>', datum)

             row = '{}, {}, {}, {}, {}, {}, {}, {}'.format(prov[0], city[0], mode[0], tmEf[0], wf[0], tmn[0], tmx[0], reli[0])
             print(row)

findData()