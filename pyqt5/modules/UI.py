# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file '_uiFiles/calculator.ui'
#
# Created by: PyQt5 UI code generator 5.11.3
#
# WARNING! All changes made in this file will be lost!

from PyQt5 import QtCore, QtGui, QtWidgets

class Ui_Main(object):
    def setupUi(self, Main):
        Main.setObjectName("Main")
        Main.resize(362, 437)
        Main.setMinimumSize(QtCore.QSize(362, 437))
        Main.setMaximumSize(QtCore.QSize(362, 437))
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("../_Sources/icon.ico"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        Main.setWindowIcon(icon)
        self.gridLayoutWidget = QtWidgets.QWidget(Main)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(10, 170, 341, 261))
        self.gridLayoutWidget.setObjectName("gridLayoutWidget")
        self.main_layout_numpad = QtWidgets.QGridLayout(self.gridLayoutWidget)
        self.main_layout_numpad.setSizeConstraint(QtWidgets.QLayout.SetDefaultConstraint)
        self.main_layout_numpad.setContentsMargins(0, 0, 0, 0)
        self.main_layout_numpad.setObjectName("main_layout_numpad")
        self.main_btn_plus = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_plus.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_plus.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_plus.setTabletTracking(False)
        self.main_btn_plus.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(8, 43, 157);")
        self.main_btn_plus.setObjectName("main_btn_plus")
        self.main_layout_numpad.addWidget(self.main_btn_plus, 4, 3, 1, 1)
        self.main_btn_result = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_result.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_result.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_result.setTabletTracking(False)
        self.main_btn_result.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(85, 255, 255);\n"
"color: rgb(8, 43, 157);")
        self.main_btn_result.setObjectName("main_btn_result")
        self.main_layout_numpad.addWidget(self.main_btn_result, 5, 3, 1, 1)
        self.main_btn_1 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_1.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_1.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_1.setTabletTracking(False)
        self.main_btn_1.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_1.setObjectName("main_btn_1")
        self.main_layout_numpad.addWidget(self.main_btn_1, 1, 0, 1, 1)
        self.main_btn_0 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_0.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_0.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_0.setTabletTracking(False)
        self.main_btn_0.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_0.setObjectName("main_btn_0")
        self.main_layout_numpad.addWidget(self.main_btn_0, 5, 1, 1, 1)
        self.main_btn_7 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_7.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_7.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_7.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_7.setObjectName("main_btn_7")
        self.main_layout_numpad.addWidget(self.main_btn_7, 4, 0, 1, 1)
        self.main_btn_minus = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_minus.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_minus.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_minus.setTabletTracking(False)
        self.main_btn_minus.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(8, 43, 157);")
        self.main_btn_minus.setObjectName("main_btn_minus")
        self.main_layout_numpad.addWidget(self.main_btn_minus, 3, 3, 1, 1)
        self.main_btn_multiply = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_multiply.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_multiply.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_multiply.setTabletTracking(False)
        self.main_btn_multiply.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(8, 43, 157);")
        self.main_btn_multiply.setObjectName("main_btn_multiply")
        self.main_layout_numpad.addWidget(self.main_btn_multiply, 1, 3, 1, 1)
        self.main_btn_3 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_3.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_3.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_3.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_3.setObjectName("main_btn_3")
        self.main_layout_numpad.addWidget(self.main_btn_3, 1, 2, 1, 1)
        self.main_btn_2 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_2.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_2.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_2.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_2.setObjectName("main_btn_2")
        self.main_layout_numpad.addWidget(self.main_btn_2, 1, 1, 1, 1)
        self.main_btn_divide = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_divide.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_divide.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_divide.setTabletTracking(False)
        self.main_btn_divide.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(8, 43, 157);\n"
"\n"
"")
        self.main_btn_divide.setObjectName("main_btn_divide")
        self.main_layout_numpad.addWidget(self.main_btn_divide, 0, 3, 1, 1)
        self.main_btn_4 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_4.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_4.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_4.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_4.setObjectName("main_btn_4")
        self.main_layout_numpad.addWidget(self.main_btn_4, 3, 0, 1, 1)
        self.main_btn_8 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_8.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_8.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_8.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_8.setObjectName("main_btn_8")
        self.main_layout_numpad.addWidget(self.main_btn_8, 4, 1, 1, 1)
        self.main_btn_5 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_5.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_5.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_5.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_5.setObjectName("main_btn_5")
        self.main_layout_numpad.addWidget(self.main_btn_5, 3, 1, 1, 1)
        self.main_btn_9 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_9.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_9.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_9.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_9.setObjectName("main_btn_9")
        self.main_layout_numpad.addWidget(self.main_btn_9, 4, 2, 1, 1)
        self.main_btn_bracket1 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_bracket1.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_bracket1.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_bracket1.setTabletTracking(False)
        self.main_btn_bracket1.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(8, 43, 157);")
        self.main_btn_bracket1.setObjectName("main_btn_bracket1")
        self.main_layout_numpad.addWidget(self.main_btn_bracket1, 0, 1, 1, 1)
        self.main_btn_6 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_6.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_6.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_6.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(255, 255, 255);")
        self.main_btn_6.setObjectName("main_btn_6")
        self.main_layout_numpad.addWidget(self.main_btn_6, 3, 2, 1, 1)
        self.main_btn_reset = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_reset.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_reset.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_reset.setTabletTracking(False)
        self.main_btn_reset.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(8, 43, 157);")
        self.main_btn_reset.setObjectName("main_btn_reset")
        self.main_layout_numpad.addWidget(self.main_btn_reset, 0, 0, 1, 1)
        self.main_btn_point = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_point.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_point.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_point.setTabletTracking(False)
        self.main_btn_point.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(8, 43, 157);")
        self.main_btn_point.setObjectName("main_btn_point")
        self.main_layout_numpad.addWidget(self.main_btn_point, 5, 2, 1, 1)
        self.main_btn_bracket2 = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_bracket2.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_bracket2.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_bracket2.setTabletTracking(False)
        self.main_btn_bracket2.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(8, 43, 157);")
        self.main_btn_bracket2.setObjectName("main_btn_bracket2")
        self.main_layout_numpad.addWidget(self.main_btn_bracket2, 0, 2, 1, 1)
        self.main_btn_percentage = QtWidgets.QPushButton(self.gridLayoutWidget)
        self.main_btn_percentage.setMinimumSize(QtCore.QSize(0, 45))
        self.main_btn_percentage.setSizeIncrement(QtCore.QSize(0, 0))
        self.main_btn_percentage.setTabletTracking(False)
        self.main_btn_percentage.setStyleSheet("font: 13pt \"나눔스퀘어\";\n"
"background-color: rgb(0, 170, 255);\n"
"color: rgb(8, 43, 157);")
        self.main_btn_percentage.setObjectName("main_btn_percentage")
        self.main_layout_numpad.addWidget(self.main_btn_percentage, 5, 0, 1, 1)
        self.widget = QtWidgets.QWidget(Main)
        self.widget.setGeometry(QtCore.QRect(10, 10, 341, 154))
        self.widget.setStyleSheet("background-color: rgb(255, 255, 255);")
        self.widget.setObjectName("widget")
        self.gridLayout_2 = QtWidgets.QGridLayout(self.widget)
        self.gridLayout_2.setContentsMargins(0, 0, 0, 0)
        self.gridLayout_2.setObjectName("gridLayout_2")
        self.main_line_input = QtWidgets.QLineEdit(self.widget)
        self.main_line_input.setMinimumSize(QtCore.QSize(0, 45))
        self.main_line_input.setStyleSheet("font: 75 15pt \"나눔스퀘어 Bold\";")
        self.main_line_input.setText("")
        self.main_line_input.setFrame(False)
        self.main_line_input.setAlignment(QtCore.Qt.AlignRight|QtCore.Qt.AlignTrailing|QtCore.Qt.AlignVCenter)
        self.main_line_input.setObjectName("main_line_input")
        self.gridLayout_2.addWidget(self.main_line_input, 0, 0, 1, 2)
        spacerItem = QtWidgets.QSpacerItem(218, 25, QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Minimum)
        self.gridLayout_2.addItem(spacerItem, 2, 0, 1, 1)
        self.main_line_output = QtWidgets.QLineEdit(self.widget)
        self.main_line_output.setMinimumSize(QtCore.QSize(0, 45))
        self.main_line_output.setStyleSheet("font: 75 20pt \"나눔스퀘어 Bold\";")
        self.main_line_output.setFrame(False)
        self.main_line_output.setAlignment(QtCore.Qt.AlignRight|QtCore.Qt.AlignTrailing|QtCore.Qt.AlignVCenter)
        self.main_line_output.setObjectName("main_line_output")
        self.gridLayout_2.addWidget(self.main_line_output, 1, 0, 1, 2)
        self.main_btn_del = QtWidgets.QPushButton(self.widget)
        self.main_btn_del.setEnabled(True)
        self.main_btn_del.setMinimumSize(QtCore.QSize(78, 28))
        self.main_btn_del.setTabletTracking(False)
        self.main_btn_del.setText("")
        self.main_btn_del.setObjectName("main_btn_del")
        self.gridLayout_2.addWidget(self.main_btn_del, 2, 1, 1, 1)

        self.retranslateUi(Main)
        QtCore.QMetaObject.connectSlotsByName(Main)

    def retranslateUi(self, Main):
        _translate = QtCore.QCoreApplication.translate
        Main.setWindowTitle(_translate("Main", "Dialog"))
        self.main_btn_plus.setText(_translate("Main", "+"))
        self.main_btn_result.setText(_translate("Main", "="))
        self.main_btn_1.setText(_translate("Main", "1"))
        self.main_btn_0.setText(_translate("Main", "0"))
        self.main_btn_7.setText(_translate("Main", "7"))
        self.main_btn_minus.setText(_translate("Main", "-"))
        self.main_btn_multiply.setText(_translate("Main", "*"))
        self.main_btn_3.setText(_translate("Main", "3"))
        self.main_btn_2.setText(_translate("Main", "2"))
        self.main_btn_divide.setText(_translate("Main", "/"))
        self.main_btn_4.setText(_translate("Main", "4"))
        self.main_btn_8.setText(_translate("Main", "8"))
        self.main_btn_5.setText(_translate("Main", "5"))
        self.main_btn_9.setText(_translate("Main", "9"))
        self.main_btn_bracket1.setText(_translate("Main", "("))
        self.main_btn_6.setText(_translate("Main", "6"))
        self.main_btn_reset.setText(_translate("Main", "C"))
        self.main_btn_point.setText(_translate("Main", "."))
        self.main_btn_bracket2.setText(_translate("Main", ")"))
        self.main_btn_percentage.setText(_translate("Main", "%"))
        self.main_line_output.setText(_translate("Main", "0"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    Main = QtWidgets.QDialog()
    ui = Ui_Main()
    ui.setupUi(Main)
    Main.show()
    sys.exit(app.exec_())

