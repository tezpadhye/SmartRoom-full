# SmartRoom
It is a web application which provides the teacher a bird’s eye view of the class with insights about students who actually need attention. This application uses a prediction model to predict future scores for each student based on not only past performance but also various socio-demographic factors to alert the teacher beforehand so measures can be taken in real time.

## Tools And Technology
- JavaScript
- React.js
- Java
- Spring Boot
- Spring Security
- MongoDB
- Python
- Scikit-Learn
- Fast API
- Docker
- Gunicorn - Uvicorn

## Features
The users of this application are teacher and student.
Features of teacher's are:
1. Monitor the student's performance prediction.
2. Provide the student's parameters and data.
3. See visual representation of student predicted marks.
4. Notify student's through email whenever predicted score is low.
5. See a list of weak performing student's in the class

Features of student's are:
1. See visual representation of their scores and predicted result
2. See a list of top performing student's in the class

## Implementation
- The frontend was implemented using React.js, which allowed for a responsive and user-friendly interface. The application can retrieve student data, predictions and display them to the teacher using visualizations. 
- The backend was built using SpringBoot with dependencies fulfilled by Maven. Spring Security ensured secure logins and robust authentication system. MongoDB was integrated to handle student data storage. It is a medium between frontend and ML Model and fetches the predictions from the machine learning model through APIs and stores it in Database. 
- The Machine Learning model was built in Python and trained using RandomForestRegressor. The model was trained on a dataset that included past performance, demographic, and social data for a group of students. The model was able to achieve an R2 score of 94% on test set, and was able to correctly predict future score within an error range of 1 mark out of 20 marks. The  ML Model is exposed using FastAPI with Pydantic handling the requests and JSON data and Uvicorn runs the webserver.




## Prediction Model Parameter
```
1. sex - student's sex (binary: "F" - female or "M" - male)
2. age - student's age (numeric: from 15 to 22)
3. address - student's home address type (binary: "U" - urban or "R" - rural)
4. famsize - family size (binary: "LE3" - less or equal to 3 or "GT3" - greater than 3)
5. Pstatus - parent's cohabitation status (binary: "T" - living together or "A" - apart)
6. Medu - mother's education (numeric: 0 - none,  1 - primary education (4th grade), 2 – 5th to 9th grade, 3 – secondary education or 4 – higher education)
7. Fedu - father's education (numeric: 0 - none,  1 - primary education (4th grade), 2 – 5th to 9th grade, 3 – secondary education or 4 – higher education)
8. Mjob - mother's job (nominal: "teacher", "health" care related, civil "services" (e.g. administrative or police), "at_home" or "other")
9. Fjob - father's job (nominal: "teacher", "health" care related, civil "services" (e.g. administrative or police), "at_home" or "other")
10. traveltime - home to school travel time (numeric: 1 - <15 min., 2 - 15 to 30 min., 3 - 30 min. to 1 hour, or 4 - >1 hour)
11. studytime - weekly study time (numeric: 1 - <2 hours, 2 - 2 to 5 hours, 3 - 5 to 10 hours, or 4 - >10 hours)
12. failures - number of past class failures (numeric: n if 1<=n<3, else 4)
13. schoolsup - extra educational support (binary: yes or no)
14. famsup - family educational support (binary: yes or no)
15. paid - extra paid classes within the course subject (Math or Portuguese) (binary: yes or no)
16. activities - extra-curricular activities (binary: yes or no)
17. nursery - attended nursery school (binary: yes or no)
18. higher - wants to take higher education (binary: yes or no)
19. internet - Internet access at home (binary: yes or no)
20. famrel - quality of family relationships (numeric: from 1 - very bad to 5 - excellent)
21. freetime - free time after school (numeric: from 1 - very low to 5 - very high)
22. health - current health status (numeric: from 1 - very bad to 5 - very good)
23. absences - number of school absences (numeric: from 0 to 93)
24. G1 - marks scored in the first term (0 to 20)
25. G2 - marks scored in the second term (0 to 20)
26. G3 - marks scored in the third term (0 to 20)
```
## Working Demo



https://user-images.githubusercontent.com/50453172/215263423-5b443617-1fd7-428d-ae8b-dbe4b74f4c48.mp4




