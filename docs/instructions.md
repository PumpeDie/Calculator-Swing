**Goals of the session:**  
Create your Graphic User Interface using Swing  
In this session you will learn :  
– To use the Swing framework, especially component and their layout.  
– To implement event listeners  

**Rules**  
In this lab, we will be using another IDE than Eclipse for building our Graphic User Interfaces (henceforth GUI). The IDE of choice is Netbeans (https://netbeans.org/downloads/).  

We will first discover Netbeans GUI capabilities by reading the Oracle documentation on the topic (Exercise 1). Then, exercise 2 will offer you the opportunity to implement a simple GUI that requires to create components, place them in the window (using layouts), and implement event (mouse) and action (keyboard) listeners.  

---

### 1. Exercise 1 : Netbeans  
- **Question 1.1** Download and install Netbeans in your virtual machine.
- **Question 1.2** Look around Netbeans GUI capabilities by reading this presentation of the different areas useful to build GUI in Netbeans : https://docs.oracle.com/javase/tutorial/uiswing/learn/netbeansbasics.html.
- **Question 1.3** Implement the CelsiusConverter GUI by following this tutorial https://docs.oracle.com/javase/tutorial/uiswing/learn/creatinggui.html.
- **Question 1.4** We will here discover the main classes of the Swing framework, that is the native framework in Java to create GUI.

  First, read carefully :
  - about Swing components : https://docs.oracle.com/javase/tutorial/uiswing/components/index.html. (You may skip "Text Component Features")
  - about Swing layouts : https://docs.oracle.com/javase/tutorial/uiswing/layout/index.html.
  - about Event listeners : https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html.

Now, we can answer the following questions :
1. What is a JFrame?
2. What is the ContentPane and what is its type?
3. How to add a JButton to the ContentPane?
4. What is a layout manager?
5. How to add a new BoxLayout to the ContentPane?
6. How to implement a MouseListener and how to bind it to a JButton in the ContentPane?
7. What is a KeyListener and how to use it? (e.g. how to display "Hello" to the standard output when the key Enter is pressed in the GUI?)

---

### 2. Exercise 2 : Calculator  
**Question 2.1** We will now create a new Swing application. This Swing application is a calculator, like the infamous Windows one.  

Your calculator will have the following features :
- Implement the following operations : add, sub, mult, div and modulo.
- Provides buttons for those operations, along with buttons for numbers 0-9, an Enter button to perform the result, and a clear button to clear the result being displayed (set the text field to the value 0).
- The result will be displayed at the top of the calculator in a JTextField. This value can be reused for further operations.

Optionally, if time allows :
- You will provide a button to switch to scientific mode. In this mode, you show a new JPanel that was until then hidden. This panel provides advanced computations: sin, cos, tan, and factorial.
- The calculator will allow complex expressions using parentheses (beware: this is a more difficult functionality to add).

In order to do this, we recommend that you first draw your GUI and materialize the different JPanel, JComponent, and Layout that you will need to then create in the Netbeans GUI editor.