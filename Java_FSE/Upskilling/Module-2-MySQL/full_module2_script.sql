
-- TABLE CREATION

CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);

CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming', 'completed', 'cancelled'),
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

CREATE TABLE Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM('pdf','image','link'),
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);


INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES (1, 'Alice Johnson', 'alice@example.com', 'New York', '2024-12-01');
INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES (2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05');
INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES (3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10');
INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES (4, 'Diana King', 'diana@example.com', 'New York', '2025-01-15');
INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES (5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');
INSERT INTO Events (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES (1, 'Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', '2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1);
INSERT INTO Events (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES (2, 'AI & ML Conference', 'Conference on AI and ML advancements.', 'Chicago', '2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3);
INSERT INTO Events (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES (3, 'Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);
INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES (1, 1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00');
INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES (2, 1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:15:00', '2025-06-10 12:30:00');
INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES (3, 2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00');
INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES (4, 3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES (1, 1, 1, '2025-05-01');
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES (2, 2, 1, '2025-05-02');
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES (3, 3, 2, '2025-04-30');
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES (4, 4, 2, '2025-04-28');
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES (5, 5, 3, '2025-06-15');
INSERT INTO Feedback (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES (1, 3, 2, 4, 'Great insights!', '2025-05-16');
INSERT INTO Feedback (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES (2, 4, 2, 5, 'Very informative.', '2025-05-16');
INSERT INTO Feedback (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES (3, 2, 1, 3, 'Could be better.', '2025-06-11');
INSERT INTO Resources (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES (1, 1, 'pdf', 'https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00');
INSERT INTO Resources (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES (2, 2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00');
INSERT INTO Resources (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES (3, 3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');


-- Q1: User Upcoming Events
SELECT u.full_name, e.title, e.start_date
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
JOIN Events e ON r.event_id = e.event_id
WHERE e.status = 'upcoming' AND u.city = e.city
ORDER BY e.start_date;

-- Q2: Top Rated Events (≥10 feedbacks)
SELECT e.title, AVG(f.rating) AS avg_rating, COUNT(*) AS feedback_count
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id
HAVING COUNT(*) >= 10
ORDER BY avg_rating DESC;

-- Q3: Inactive Users (no registration in last 90 days)
SELECT u.*
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
GROUP BY u.user_id
HAVING MAX(r.registration_date) IS NULL OR MAX(r.registration_date) < CURDATE() - INTERVAL 90 DAY;

-- Q4: Peak Session Hours (10 AM to 12 PM)
SELECT event_id, COUNT(*) AS session_count
FROM Sessions
WHERE TIME(start_time) BETWEEN '10:00:00' AND '11:59:59'
GROUP BY event_id;

-- Q5: Most Active Cities
SELECT u.city, COUNT(DISTINCT r.user_id) AS total_users
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY total_users DESC
LIMIT 5;

-- Q6: Event Resource Summary
SELECT event_id,
       SUM(resource_type = 'pdf') AS pdfs,
       SUM(resource_type = 'image') AS images,
       SUM(resource_type = 'link') AS links
FROM Resources
GROUP BY event_id;

-- Q7: Low Feedback Alerts
SELECT u.full_name, e.title, f.rating, f.comments
FROM Feedback f
JOIN Users u ON f.user_id = u.user_id
JOIN Events e ON f.event_id = e.event_id
WHERE f.rating < 3;

-- Q8: Sessions per Upcoming Event
SELECT e.title, COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id;

-- Q9: Organizer Event Summary
SELECT u.full_name, e.status, COUNT(*) AS total_events
FROM Events e
JOIN Users u ON e.organizer_id = u.user_id
GROUP BY e.organizer_id, e.status;

-- Q10: Feedback Gap (registrations but no feedback)
SELECT DISTINCT e.title
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL;

-- Q11: Daily New User Count (last 7 days)
SELECT registration_date, COUNT(*) AS user_count
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date;

-- Q12: Event with Maximum Sessions
SELECT e.title, COUNT(s.session_id) AS session_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id
HAVING session_count = (
    SELECT MAX(session_count)
    FROM (
        SELECT COUNT(*) AS session_count
        FROM Sessions
        GROUP BY event_id
    ) AS sub
);

-- Q13: Average Rating per City
SELECT e.city, AVG(f.rating) AS avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.city;

-- Q14: Most Registered Events (Top 3)
SELECT e.title, COUNT(*) AS total_registrations
FROM Registrations r
JOIN Events e ON r.event_id = e.event_id
GROUP BY r.event_id
ORDER BY total_registrations DESC
LIMIT 3;

-- Q15: Event Session Time Conflict
SELECT s1.event_id, s1.title AS session1, s2.title AS session2
FROM Sessions s1
JOIN Sessions s2 ON s1.event_id = s2.event_id AND s1.session_id < s2.session_id
WHERE s1.start_time < s2.end_time AND s2.start_time < s1.end_time;

-- Q16: Unregistered Active Users (joined in last 30 days)
SELECT *
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
  AND r.registration_id IS NULL;

-- Q17: Multi-Session Speakers
SELECT speaker_name, COUNT(*) AS session_count
FROM Sessions
GROUP BY speaker_name
HAVING session_count > 1;

-- Q18: Resource Availability Check
SELECT e.title
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
WHERE r.resource_id IS NULL;

-- Q19: Completed Events with Feedback Summary
SELECT e.title, COUNT(DISTINCT r.user_id) AS total_registrations, AVG(f.rating) AS avg_rating
FROM Events e
LEFT JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id;

-- Q20: User Engagement Index
SELECT u.full_name,
       COUNT(DISTINCT r.event_id) AS events_attended,
       COUNT(DISTINCT f.feedback_id) AS feedback_given
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
LEFT JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id;

-- Q21: Top Feedback Providers
SELECT u.full_name, COUNT(*) AS total_feedbacks
FROM Feedback f
JOIN Users u ON f.user_id = u.user_id
GROUP BY f.user_id
ORDER BY total_feedbacks DESC
LIMIT 5;

-- Q22: Duplicate Registrations Check
SELECT user_id, event_id, COUNT(*) AS reg_count
FROM Registrations
GROUP BY user_id, event_id
HAVING reg_count > 1;

-- Q23: Registration Trends (past 12 months)
SELECT DATE_FORMAT(registration_date, '%Y-%m') AS month, COUNT(*) AS reg_count
FROM Registrations
WHERE registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY month
ORDER BY month;

-- Q24: Average Session Duration per Event
SELECT event_id,
       AVG(TIMESTAMPDIFF(MINUTE, start_time, end_time)) AS avg_duration_min
FROM Sessions
GROUP BY event_id;

-- Q25: Events Without Sessions
SELECT e.title
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE s.session_id IS NULL;