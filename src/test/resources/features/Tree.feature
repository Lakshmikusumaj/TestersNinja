@Tree @LaunchHome @ValidLogin
Feature: Validation Tree home page

 Background: User navigate to the Tree page
   Given User is logged in to the DSAlgo portal and on Tree page
   
@Tree_0001
  Scenario Outline: User navigate to different TopicS Covered page in Tree module
  When User clicks "<TopicsCovered>" link in Tree page
  Then user should be redirected to "<TopicsCovered>" Tree page
   
   Examples:
     | TopicsCovered                  |       
     | Overview of Trees              |
     | Terminologies                  |
     | Types of Trees                 |
     | Tree Traversals                |
     | Traversals-Illustration        |
     | Binary Trees                   |
     | Types of Binary Trees          |
     | Implementation in Python       |
     | Binary Tree Traversals         |
     | Implementation of Binary Trees |
     | Applications of Binary trees   |
     | Binary Search Trees            |
     | Implementation Of BST          |
@Tree_0002
  Scenario Outline: navigate to "<Overview of Trees>" page for Try here
  Given User is on the Overview of Trees page in Tree
  When User clicks Try Here and enter "<TestCaseName>" on respective Overview of Trees page in Tree
  Then user should see  "<TestCaseName>" on the tree try editor page 
  
     Examples:
      |TestCaseName          |
      | PythonCode_Valid	 |
      | PythonCode_Invalid	 |         
     
  