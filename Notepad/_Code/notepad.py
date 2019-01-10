# -*- coding: utf-8 -*-

import sys
from PyQt5.QtGui import *
from PyQt5.QtCore import *
from PyQt5.QtWidgets import *
from PyQt5 import uic

ui_Path = '../_uiFiles/notepad.ui'

class MainDialog(QDialog):
    def __init__(self):
        super().__init__()
        uic.loadUi(ui_Path, self)

app = QApplication(sys.argv)
main_dialog = MainDialog()
main_dialog.show()
app.exec()
