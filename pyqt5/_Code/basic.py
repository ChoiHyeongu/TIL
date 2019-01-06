# -*- coding: utf-8 -*-

import sys
from modules import UI
from PyQt5.QtGui import *
from PyQt5.QtCore import *
from PyQt5.QtWidgets import *

class MainDialog(QDialog, UI.Ui_Main):
    def __init__(self):
        QDialog.__init__(self, None, Qt.WindowStaysOnTopHint)
        self.setupUi(self)

        # NumberPad
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

        # Calculate Function
        self.main_btn_plus.clicked.connect(lambda state, button=self.main_btn_plus: self.numClicked(state, button))
        self.main_btn_minus.clicked.connect(lambda state, button=self.main_btn_minus: self.numClicked(state, button))
        self.main_btn_multiply.clicked.connect(lambda state, button=self.main_btn_multiply: self.numClicked(state, button))
        self.main_btn_divide.clicked.connect(lambda state, button=self.main_btn_divide: self.numClicked(state, button))

        self.main_btn_bracket1.clicked.connect(lambda state, button=self.main_btn_bracket1: self.numClicked(state, button))
        self.main_btn_bracket2.clicked.connect(lambda state, button=self.main_btn_bracket2: self.numClicked(state, button))
        self.main_btn_point.clicked.connect(lambda state, button=self.main_btn_point: self.numClicked(state, button))

        self.main_btn_percentage.clicked.connect(self.percentage)
        self.main_btn_result.clicked.connect(self.makeResult)
        self.main_btn_reset.clicked.connect(self.reset)
        self.main_btn_del.clicked.connect(self.delete)

        # self.main_btn_del.setStyleSheet('image:url(../_Sources/delete.png); border:0px;')
        self.main_btn_del.setStyleSheet(
            '''
            QPushButton{image:url(../_Sources/delete.png); border:0px;}
            QPushButton:hover{image:url(../_Sources/delete_red.png); border:0px;}
            ''')

    def numClicked(self, state, button):

        exist_line_text = self.main_line_input.text()
        now_text_num = button.text()
        self.main_line_input.setText(exist_line_text + now_text_num)

    def makeResult(self):

        try:
            result = eval(self.main_line_input.text())
            self.main_line_output.setText(str(result))
        except Exception as e:
            print(e)
            pass

    def reset(self):
        self.main_line_input.clear()
        self.main_line_output.setText('0')

    def delete(self):
        exist_line_text = self.main_line_input.text()
        self.main_line_input.setText(exist_line_text[:-1])

    def percentage(self):
        val = float(self.main_line_input.text())
        val = val * 0.01
        self.main_line_output.setText(str(val))

app = QApplication(sys.argv)
main_dialog = MainDialog()
main_dialog.show()
app.exec()
