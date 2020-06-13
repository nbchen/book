# book
书城项目_javaweb版本


# 安全问题
```
moderate severity
Vulnerable versions: <= 2.3.2
Patched version: No fix
text/impl/DefaultTextCreator.java, text/impl/ChineseTextProducer.java, and text/impl/FiveLetterFirstNameTextCreator.java in kaptcha 2.3.2 use the Random (rather than SecureRandom) function for generating CAPTCHA values, which makes it easier for remote attackers to bypass intended access restrictions via a brute-force approach.
```
