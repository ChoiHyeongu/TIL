# -*- coding: utf-8 -*-

import sys
from PyQt5.QtGui import *
from PyQt5.QtCore import *
from PyQt5.QtWidgets import *
from PyQt5 import uic

ui_calculator = '../_uiFiles/calculator.ui'

class MainDialog(QDialog):
    def __init__(self):
        QDialog.__init__(self, None)
        uic.loadUi(ui_calculator, self)

        self.main_btn_0.clicked.connect(lambda state, button=self.main_btn_0: self.numClicked(state, button))
        self.main_btn_1.clicked.connect(lambda state, button=self.main_btn_1: self.numClicked(state, button))
        self.main_btn_2.clicked.connect(lambda state, button=self.main_btn_2: self.numClicked(state, button))
        self.main_btn_3.clicked.connect(lambda state, button=self.main_btn_3: self.numClicked(state, button))
        self.main_btn_4.clicked.connect(lambda state, button=self.main_btn_4: self.numClicked(state, button))
        self.main_btn_5.clicked.connect(lambda state, button=self.main_btn_5: self.numClicked(state, button))
        self.main_btn_6.clicked.connect(lambda state, button=self.main_btn_6: self.numClicked(state, button))
        self.main_btn_7.clicked.connect(lambda state, button=self.main_btn_7: self.numClicked(state, button))
        self.main_btn_8.clicked.connect(lambda state, button=self.main_btn_8: self.numClicked(state, button))
        self.main_btn_9.clicked.connect(lambda state, button=self.main_btn_9: self.numClicked(state, button))

        self.main_btn_plus.clicked.connect(lambda state, button=self.main_btn_plus: self.numClicked(state, button))
        self.main_btn_minus.clicked.connect(lambda state, button=self.main_btn_minus: self.numClicked(state, button))
        self.main_btn_multiply.clicked.connect(lambda state, button=self.main_btn_multiply: self.numClicked(state, button))
        self.main_btn_divide.clicked.connect(lambda state, button=self.main_btn_divide: self.numClicked(state, button))

        self.main_btn_result.clicked.connect(self.makeResult)

    def numClicked(self, state, button):
        exist_line_text = self.main_line_input.text()
        now_text_num = button.text()
        self.main_line_input.setText(exist_line_text + now_text_num)

    def makeResult(self):
        result = eval(self.main_line_input.text())
        print(type(result))
        self.main_line_output.setText(str(result))

app = QApplication(sys.argv)
main_dialog = MainDialog()
main_dialog.show()
app.exec()
