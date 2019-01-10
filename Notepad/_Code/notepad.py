# -*- coding: utf-8 -*-

import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

ui_Path = '../_uiFiles/notepad.ui'

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi(ui_Path, self)

app = QApplication(sys.argv)
main_window = MainWindow()
main_window.show()
app.exec()
