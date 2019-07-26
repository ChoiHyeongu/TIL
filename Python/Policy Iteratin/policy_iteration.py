# -*- coding: utf-8 -*-

import random
from environment import GraphicDisplay, Env

class PolicyIteration:
    def __init__(self, env):
        self.env = env
        self.value_table = [[0.0] * env.width for _ in range(env.height)]
        self.policy_table = [[[0.25, 0.25, 0.25, 0.25]] * env.width for _ in range(env.height)]

        # 마침 상태의 설정
        self.policy_table[2][2] = []
        # 감가율
        self.discount_factor = 0.9



