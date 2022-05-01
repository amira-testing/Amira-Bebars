Feature: Register

  @Facebook
  Scenario Outline:user Login with parent facebook account then register with test facebook account

    Given user login with UserName "<username>" and  Password "<password>" and login
    #When user create facebook App with "<appName>" and "<email>"
   # And user reenter password"<password>"
    Then user register with test facebook account


    Examples:
      | username | password | appName | email |
      | username | password | appName | email |

