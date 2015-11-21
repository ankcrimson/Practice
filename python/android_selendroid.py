import os
import unittest

from appium import webdriver
from appium.webdriver.common.touch_action import TouchAction
from appium.webdriver.common.multi_action import MultiAction

from time import sleep

# Returns abs path relative to this file and not cwd
PATH = lambda p: os.path.abspath(
    os.path.join(os.path.dirname(__file__), p)
)

class ComplexAndroidTests(unittest.TestCase):
    def setUp(self):
        desired_caps = {}
        desired_caps['browserName'] = 'android'
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.3'
        desired_caps['deviceName'] = 'GT-I9300'
        desired_caps['automationName'] = 'selendroid'
        desired_caps['app'] = PATH(
            'selendroid-test-app.apk'
        )

        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
        self.driver.quit()

    def test_scroll(self):
        sleep(2)
        els = self.driver.find_element_by_class_name('android.widget.ImageButton')
        els.click()
        sleep(10)
        
        
        
        #btn = self.driver.find_element_by_class_name('android.webkit.WebView')
        #btn.click()


        #
        selfview = self.driver.contexts[0]
        webview = self.driver.contexts[1]
        print ('>>%s<<' % webview)
        #contexts = self.driver.contexts
        self.driver.switch_to.context(webview)
        self.driver.get("http://m.nike.com/us/en_us/pd/air-zoom-pegasus-32-running-shoe/pid-10294427/pgid-10266840")

        sleep(10)

        self.driver.switch_to.context(selfview)
        

        print ('Now trying TouchAction')
        e1 = TouchAction()
        e1.press(x=150, y=100).release()

        e2 = TouchAction()
        e2.press(x=250, y=100).release()


        smile = TouchAction()
        smile.press(x=400, y=800) \
            .move_to(x=-1, y=1) \
            .move_to(x=-1, y=1) \
            .move_to(x=-1, y=1) \
            .move_to(x=-1, y=1) \
            .move_to(x=-1, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-2, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-3, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-4, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=1) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=0) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-5, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-4, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-3, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-2, y=-1) \
            .move_to(x=-1, y=-1) \
            .move_to(x=-1, y=-1) \
            .move_to(x=-1, y=-1) \
            .move_to(x=-1, y=-1) \
            .move_to(x=-1, y=-1)
        smile.release()
        ma = MultiAction(self.driver)
        ma.add(e1,e2,smile)
        ma.perform()
        sleep(10)



if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(ComplexAndroidTests)
    unittest.TextTestRunner(verbosity=2).run(suite)