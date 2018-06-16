# -*- coding: utf-8 -*-
from django.shortcuts import render
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from pytz import timezone
import datetime
import json
from inform import *


def keyboard(request):
    return JsonResponse({
        'type': 'buttons',
        'buttons': ['오늘급식', '내일급식']
    })


@csrf_exempt
def answer(request):
    json_str = ((request.body).decode('utf-8'))
    received_json_data = json.loads(json_str)
    datacontent = received_json_data['content']

    # date
    # 오늘
    dt1 = datetime.datetime.today()

    local_date1 = dt1.strftime("%Y.%m.%d")
    local_weekday1 = dt1.weekday()
    # 오늘

    # 내일
    dt2 = datetime.datetime.today() + datetime.timedelta(days=1)

    local_date2 = dt2.strftime("%Y.%m.%d")
    local_weekday2 = dt2.weekday()
    # 내일
    # date

    if datacontent == '오늘급식':

        # 시간 관련
        meal_date = str(local_date1)
        l_wkday = int(local_weekday1)
        # 시간 관련

        # 파싱
        l_l = get_diet(2, meal_date, l_wkday)
        # 파싱

        if len(l_l) == 1:
            lunch = "급식이 없습니다."
        else:
            lunch = meal_date + " 중식\n" + l_l

    return JsonResponse({
        'message': {
            'text': lunch
        },
        'keyboard': {
            'type': 'buttons',
            'buttons': ['오늘급식', '내일급식']
        }
    })


    elif datacontent == '내일급식':

        meal_date2 = str(local_date2)
        l_wkday2 = int(local_date2)

        l_l2 = get_diet(2, meal_date2, l_wkday2)

        lunch = meal_date2 + " 중식\n" + l_l2

    return JsonResponse({
        'message': {
            'text' = lunch
        },
        keyboard: {
            'type': 'buttons',
            'buttons':['오늘급식', '내일급식']
}       }
    })


