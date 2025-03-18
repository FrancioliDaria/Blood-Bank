Donor and Appointment Management System
Overview
This web application allows users to manage donor profiles and appointments with doctors. Donors can view and edit their information, while doctors can manage appointment requests from donors. The system supports pagination for appointment lists and provides functionality to accept or decline appointments.

Features
Donor Profile Management: Donors can view and update their personal information such as name, email, and blood type.
Appointment Management: Doctors can view appointments from donors and choose to accept or decline them.
Pagination: Appointment lists are paginated to show a limited number of appointments per page.
Responsive UI: The application is designed to adapt to different screen sizes.
Technologies Used
HTML: For the structure of the web pages.
CSS: For styling the UI.
JavaScript: For handling dynamic interactions, such as fetching data from APIs and updating the DOM.
API: The backend APIs are assumed to be available at http://localhost:8081, but this can be changed based on the environment.

The HTML structure contains a basic layout for displaying donor information and appointments. It includes:

A table for displaying donor details.
A table for listing appointments.
Pagination controls for navigating between pages of appointments.
CSS (styles.css)
The CSS file provides basic styles to ensure the application is visually appealing and user-friendly. The styles are designed to handle responsiveness, so the page adjusts to different screen sizes.

JavaScript (script.js)
This file contains the logic for interacting with the backend and updating the frontend.

fetchUserInformation(): Fetches and displays the donor's profile information.
fetchAppointments(): Fetches and displays a list of appointments for the logged-in user (either a donor or doctor).
Pagination: Handles pagination of appointments, allowing the user to navigate between pages.
Appointment Actions: Doctors can accept or decline appointments, which will be reflected in the UI.
How to Use
Setting up the Backend:

Ensure that your backend is running and accessible at http://localhost:8081 or update the API URLs in the JavaScript code if your backend is hosted elsewhere.
Running the Frontend:

Open the index.html file in a browser.
The application will make API calls to fetch data and populate the tables for donor information and appointments.
Interacting with the System:

For Donors:
The donor’s profile will be displayed automatically on page load.
Donors can edit their profile and click "Save" to update the information.
For Doctors:
The doctor can view appointments for the logged-in donor (retrieved from localStorage).
Doctors can accept or decline appointments, which will update the status visually.
Pagination:

Appointments are paginated, with 4 items displayed per page.
Use the "Previous" and "Next" buttons to navigate between pages.
API Endpoints
The frontend makes requests to the following API endpoints:

Get Donor Information:

GET /user/register?donorId={donorId}
Returns the donor's profile details (first name, last name, email, blood type).
Get Appointments:

GET /appointments?donorId={donorId} (for donors)
GET /appointments?doctorId={doctorId} (for doctors)
Returns a list of appointments for the given user (either a donor or a doctor).
Update Donor Information:

PUT /user/edit
Sends updated donor information (first name, last name, email, blood type) to the backend.
Accept Appointment:

PUT /appointments/accept/{appointmentId}
Updates the appointment status to "accepted."
Decline Appointment:

PUT /appointments/decline/{appointmentId}
Updates the appointment status to "declined."
Example of an Appointment Row
For doctors, the appointment rows display the following:

Date of the appointment.
Time of the appointment.
"Accept" and "Decline" buttons for each appointment.
When a doctor clicks on either button, the row's appearance is updated to reflect the status change.

Known Issues & Future Enhancements
Appointment Actions: Currently, the acceptance or decline of an appointment only affects the UI. Backend API integration should be added to persist the appointment status.
Form Validation: The donor's profile update form does not currently validate input fields. This should be added for better user experience.
Error Handling: While there are basic error messages in the console, a more user-friendly error handling system should be implemented (e.g., showing alerts or notification messages).
