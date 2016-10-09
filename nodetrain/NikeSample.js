module.exports={
'NikePlus Home' : function (browser){
browser
.url("https://secure-nikeplus.nike.com/plus/")
.windowMaximize()
.pause(1000)
.assert.containsText('a[id="button_sign_in"]','LOG IN')
.click('a[id=button_sign_in]')
.assert.containsText('span[class="or_text"]','LOG IN WITH NIKE+')
.setValue('input[id="login_email"]',browser.globals.email)
.setValue('input[id="login_password"]',browser.globals.pwd)
.pause(2000)
.click('a[id=login_popup_submit]')
.pause(5000)
.assert.containsText('a[title="DASHBOARD"]','DASHBOARD')
.assert.containsText('a[title="ACTIVITY"]','ACTIVITY')
.assert.containsText('a[title="PLACES"]','PLACES')
.assert.containsText('a[title="NIKE+ GEAR"]','NIKE+ GEAR')
.pause(1000)
},

'NikePlus Settings': function(browser){
browser
.click('a[id="button_profile_dropdown"]')
.assert.containsText('a[data-nptracking="profileDDL_settings"]', 'ACCOUNT SETTINGS')
.click('a[data-nptracking="profileDDL_settings"]')
.pause(5000)
.useXpath()
.assert.containsText("//*[@id='settings_container']/div[2]/div/form/h2",'ACCOUNT SETTINGS')
.useCss()
.click('a[id="edit_avatar_btn"]')

.setValue('input[type="file"]', 'C:\Users\Public\Pictures\Sample Pictures\Desert.jpg')
.click('div.button_container')
.useXpath()
.click("//*[@id='crop_modal']/div[2]/div[2]/div/a[4]")
.pause(5000)
.useCss()
.clearValue('input[class=" name_input"]')
.pause(5000)
.setValue('input[class=" name_input"]',browser.globals.name)
.clearValue('input[class=" small_text_input"]')
.setValue('input[class=" small_text_input"]',browser.globals.pin)
.useXpath()
.assert.containsText("//*[@id='save_btn']",'SAVE')
.click("//*[@id='save_btn']")
.pause(5000)
.assert.containsText("//*[@id='settings_container']/div[2]/div/form/div[8]/div[1]/p",'Your changes have been saved successfully')
.useCss()
.pause(2000)
.click('a[id="button_profile_dropdown"]')
.assert.containsText('a[data-nptracking="profileDDL_logout"]', 'LOG OUT')
.click('a[data-nptracking="profileDDL_logout"]')
.pause(5000) 
.end();
}
};

