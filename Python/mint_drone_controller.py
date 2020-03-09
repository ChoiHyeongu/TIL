#!/usr/bin/env python
import rospy
import readchar
import mavros_setpoints
import threading
import time
from geometry_msgs.msg import Point, PoseStamped
from mavros_msgs.msg import *
from mavros_msgs.srv import *

# Mint drone
import mint_drone

def main():
    rospy.init_node('setpoint_node', anonymous=True)

    mintDrone = mint_drone.Controller()

    # 스레드 시작
    mintDrone.startThread()

    rospy.Subscriber('mavros/state', State, mintDrone.stateCb)
    rospy.Subscriber('mavros/local_position/pose', PoseStamped, mintDrone.posCb)   

    # WaypointLocal이 들어갈 배열
    mission = []

    while input != 'Q':
        print("A: Arm | D: Disarm | T: Take off | M: Add mission | P: Play Missions | V: Print missions | O: Move| Q: Quit")
        input = raw_input()
        if input == 'A':
            mintDrone.arm()
        elif input == 'D':
            mintDrone.disarm()
        elif input == 'T':
            mintDrone.takeOff()
        elif input == 'M':
            x = 'A'
            count = 1
            while True:
                print("Mission ",count)
                print("X, Y, Z | S: Stop")
                x = raw_input()
                if x == 'S':
                    break
                y = raw_input()
                z = raw_input()
                waypointLocal = WaypointLocal(int(x), int(y), int(z))
                mission.append(waypointLocal)
                count += 1
        elif input == 'P':
            mintDrone.playMission(mission)
        elif input == 'V':
            mintDrone.printMission(mission)
        elif input == 'O':
            x, y, z = [int(x) for x in raw_input().split()]
            waypointLocal = WaypointLocal(x, y, z)
            mintDrone.move(waypointLocal)
            
        print("Rospy.spin()")

if __name__ == '__main__':
	try:
		main()
	except rospy.ROSInterruptException:
		pass
