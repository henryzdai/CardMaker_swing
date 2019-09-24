# WPI_CS509

## Project title

Card Maker

## Name

Zekun Dai

George Heineman(Instructor)

## Motivation

Using Java Swing to create a card maker app for user to create their customized gift card.

## Design Documents
### Use Cases
1. User start app in "StartMenu"'s main function.
2. User open card maker choose "Make card" or "Load Card"
3. User click "Make card", set properties of the card in creating card frame, and then click "OK" to open main window.
4. Open "Make card", click "Add visual element" button, then first have to **confirm it is front page** to continue, after, choose which type element to add, if the element is image, it directly add the image for now. If it's text, the app shows a text editor frame, in the frame, use can enter text, and then **select the text in the text filed, user can now change the text size and font**. If not select the text, the change won't apply. Click "Submit" if done edit text.
5. At main window, user click "Edit Visual Element" to then choose element type to change the existing text or image.
6. User can click "Display all" to display all pages of the card.
7. User can click "Copy Visual Element" or "Paste Visual Element", choose element type to performance copy and paste action.
8. User click "Save" to save the card, otherwise **it will not be saved automaticlly**.
9. User click "Load card", and choose to load, delete, duplicate, update the card.
10. If user wants to duplicate a card and apply change, click "Duplicate" then click "Update" to change the information; **Otherwise, it's only a duplicated version.**


### Mockup

1.User opens the app, and it shows the first menu panel. As follows, it has 2 buttons: "Create Card", "Card List".
![](./Mockup/menupanel.png)
2.If user clicks "Create Card" button, the app opens a new panel shows a dialog for user to enter the cards name. If clicks "cancel", it returns 1.
![](./Mockup/createdialog.png)
If user clicks "create", then the app opens a new window that shows the main app window, with the option to see "front page", "back page", "Inside-left page" and "Inside-right page". In current window, it has 5 buttons "Add visual element",  "Del visual element", "Copy visual element", "Paste visual element", "Save", "Add visual element",on top and with card name below buttons. Alongside the card name, the user can choose event type of the card, and has an input box to enter the recipient's name.
![](./Mockup/mainwindow.png)
    2.1 If user clicks "Add visual element" button, user can add ether image or text to the "front page" section.
    2.2 If user clicks "Del visual element" button, user can delete ether image or text to the "front page" section.
    2.3 If user clicks "Copy visual element" button, user can copy selected image or text from the "front page" section.
    2.4 If user clicks "Paste visual element" button, user can paste selected image or text from the "front page" section of same or different card.
    2.5 If user clicks "Save" button, the app saves the created card to certain format, and can be loaded at later times.
    ![](./Mockup/importdialog.png)
3.If user clicks "Card List" button, the app opens a new panel that shows current in-library cards. Along with 5 buttons on the top "Load card",  "Delete card",  "Duplicate card",  "Display card",  "Create card", 
![](./Mockup/cardlist.png)
3.1.If user clicks "Load Card" button, the app shows import window for user to select the saved card that the user wants to load.
![](./Mockup/importdialog.png)
3.2.If user selects a card and clicks "Delete Card" button, the app deletes the card from library.

3.3.If user selects a card and clicks "Duplicate Card" button, the app duplicates the card.

3.4.If user selects a card and clicks "Display Card" button, the app opens main window like in 2.

3.5.If user selects a card and clicks "Create Card" button, the app follows process like 2.

## Build status

[![Build Status](https://travis-ci.com/travis-ci/travis-web.svg?branch=master)](https://travis-ci.com/travis-ci/travis-web)


## Screenshots


## Tech/framework used


<b>Built with</b>

- Java Swing

## Features

What makes your project stand out?

## Installation

Works fine in IntelliJ idea 2019.2 version.

## Credits

Zekun Dai

#### Anything else that seems useful

## License

MIT ©
