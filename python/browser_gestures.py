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

class BrowserGesturesTest(unittest.TestCase):
    def setUp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.2'
        desired_caps['deviceName'] = 'Android Emulator'
        desired_caps['browserName'] = 'Browser'
        

        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
        self.driver.quit()

    def test_find_elements(self):
        # pause a moment, so xml generation can occur
        sleep(2)

        self.driver.get("http://m.nike.com/us/en_us/pd/air-zoom-pegasus-32-running-shoe/pid-10294427/pgid-10266840")
        #els = self.driver.find_elements_by_xpath('//android.widget.TextView')
        #Eself.assertEqual('API Demos', els[0].text)

        #el = self.driver.find_element_by_xpath('//android.widget.TextView[contains(@text, "Animat")]')
        #self.assertEqual('Animation', el.text)

        #el = self.driver.find_element_by_accessibility_id("App")
        #el.click()

        #els = self.driver.find_elements_by_android_uiautomator('new UiSelector().clickable(true)')
        # there are more, but at least 10 visible
        #self.assertLess(10, len(els))
        # the list includes 2 before the main visible elements
        #self.assertEqual('Action Bar', els[2].text)

        #els = self.driver.find_elements_by_xpath('//android.widget.TextView')
        #self.assertLess(10, len(els))
        #self.assertEqual('Action Bar', els[1].text)
        smile = TouchAction()
        smile.press(x=110, y=200) \
            .move_to(x=1, y=1) \
            .move_to(x=1, y=1) \
            .move_to(x=1, y=1) \
            .move_to(x=1, y=1) \
            .move_to(x=1, y=1) \
            .move_to(x=2, y=1) \
            .move_to(x=2, y=1) \
            .move_to(x=2, y=1) \
            .move_to(x=2, y=1) \
            .move_to(x=2, y=1) \
            .move_to(x=3, y=1) \
            .move_to(x=3, y=1) \
            .move_to(x=3, y=1) \
            .move_to(x=3, y=1) \
            .move_to(x=3, y=1) \
            .move_to(x=4, y=1) \
            .move_to(x=4, y=1) \
            .move_to(x=4, y=1) \
            .move_to(x=4, y=1) \
            .move_to(x=4, y=1) \
            .move_to(x=5, y=1) \
            .move_to(x=5, y=1) \
            .move_to(x=5, y=1) \
            .move_to(x=5, y=1) \
            .move_to(x=5, y=1) \
            .move_to(x=5, y=0) \
            .move_to(x=5, y=0) \
            .move_to(x=5, y=0) \
            .move_to(x=5, y=0) \
            .move_to(x=5, y=0) \
            .move_to(x=5, y=0) \
            .move_to(x=5, y=0) \
            .move_to(x=5, y=0) \
            .move_to(x=5, y=-1) \
            .move_to(x=5, y=-1) \
            .move_to(x=5, y=-1) \
            .move_to(x=5, y=-1) \
            .move_to(x=5, y=-1) \
            .move_to(x=4, y=-1) \
            .move_to(x=4, y=-1) \
            .move_to(x=4, y=-1) \
            .move_to(x=4, y=-1) \
            .move_to(x=4, y=-1) \
            .move_to(x=3, y=-1) \
            .move_to(x=3, y=-1) \
            .move_to(x=3, y=-1) \
            .move_to(x=3, y=-1) \
            .move_to(x=3, y=-1) \
            .move_to(x=2, y=-1) \
            .move_to(x=2, y=-1) \
            .move_to(x=2, y=-1) \
            .move_to(x=2, y=-1) \
            .move_to(x=2, y=-1) \
            .move_to(x=1, y=-1) \
            .move_to(x=1, y=-1) \
            .move_to(x=1, y=-1) \
            .move_to(x=1, y=-1) \
            .move_to(x=1, y=-1)
        smile.release()

        ma = MultiAction(self.driver)
        ma.add(smile)
        ma.perform()

        # so you can see it
        sleep(10)



if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(BrowserGesturesTest)
    unittest.TextTestRunner(verbosity=2).run(suite)