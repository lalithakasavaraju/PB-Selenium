@signIn

  Feature: Multi Account Signin
    Scenario Outline: As a user, I want the ability to select an account to login to
      Given I am on perkbox homepage
      When I am a registered user and I login to my account
      When I click on my "<accounts>"
      Then I should land on account login page with "<url>"
      And my "<email>" should be populated in the email input field

      Examples:
      | accounts         | url                                                | email |
      | themistrypenguin | https://themistrypenguin.perkbox.com/welcome/login | pooja@perkbox.co.uk |
      | demo-test-france | https://demo-test-france.perkbox.com/welcome/login | pooja@perkbox.co.uk |
      | home             | https://home.perkbox.com/welcome/login             | pooja@perkbox.co.uk |
      | poojatest2       | https://poojatest2.perkbox.com/welcome/login       | pooja@perkbox.co.uk |
      | demoone          | https://demoone.perkbox.com/welcome/login          | pooja@perkbox.co.uk |
      | guild            | https://guild.perkbox.com/welcome/login            | pooja@perkbox.co.uk |
      | testtenant3      | https://testtenant3.perkbox.com/welcome/login      | pooja@perkbox.co.uk |



    Scenario: Verify user should not login with a unregistered account
      Given I am not a registered user with perkbox and I try to login
      When I give my email and select continue
      Then I should receive error message "User is not found"




