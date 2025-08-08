const API_URL = "http://localhost:8080/api/students";

// Show only one section at a time
function showSection(sectionId) {
    document.querySelectorAll(".section").forEach(sec => sec.style.display = "none");
    document.getElementById(sectionId).style.display = "block";

    if (sectionId === "showSection") {
        fetchStudents();
    }
}

// Add a new student
async function addStudent() {
    const student = {
        rollNo: document.getElementById("addRollNo").value,
        name: document.getElementById("addName").value,
        address: document.getElementById("addAddress").value,
        email: document.getElementById("addEmail").value,
        mobileNumber: document.getElementById("addMobileNumber").value,
        standard: document.getElementById("addStandard").value,
        marks: document.getElementById("addMarks").value
    };

    await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(student)
    });

    alert("Student Added Successfully!");
    clearInputs();
}

// Load student for update
async function loadStudentForUpdate() {
    const rollNo = document.getElementById("updateRollNo").value;
    const response = await fetch(`${API_URL}/${rollNo}`);

    if (response.ok) {
        const student = await response.json();
        document.getElementById("updateName").value = student.name;
        document.getElementById("updateAddress").value = student.address;
        document.getElementById("updateEmail").value = student.email;
        document.getElementById("updateMobileNumber").value = student.mobileNumber;
        document.getElementById("updateStandard").value = student.standard;
        document.getElementById("updateMarks").value = student.marks;
        document.getElementById("updateForm").style.display = "block";
    } else {
        alert("Student not found!");
    }
}

// Update student
async function updateStudent() {
    const rollNo = document.getElementById("updateRollNo").value;
    const student = {
        name: document.getElementById("updateName").value,
        address: document.getElementById("updateAddress").value,
        email: document.getElementById("updateEmail").value,
        mobileNumber: document.getElementById("updateMobileNumber").value,
        standard: document.getElementById("updateStandard").value,
        marks: document.getElementById("updateMarks").value
    };

    await fetch(`${API_URL}/${rollNo}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(student)
    });

    alert("Student Updated Successfully!");
}

// Delete student
async function deleteStudentByRollNo() {
    const rollNo = document.getElementById("deleteRollNo").value;
    const response = await fetch(`${API_URL}/${rollNo}`, { method: "DELETE" });

    if (response.ok) {
        alert("Student Deleted Successfully!");
    } else {
        alert("Student not found!");
    }
}

// Show all students
async function fetchStudents() {
    const response = await fetch(API_URL);
    const students = await response.json();
    const tableBody = document.getElementById("studentTable");
    tableBody.innerHTML = "";

    students.forEach(student => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${student.rollNo}</td>
            <td>${student.name}</td>
            <td>${student.address}</td>
            <td>${student.email}</td>
            <td>${student.mobileNumber}</td>
            <td>${student.standard}</td>
            <td>${student.marks}</td>
        `;
        tableBody.appendChild(row);
    });
}

function clearInputs() {
    document.querySelectorAll("input").forEach(input => input.value = "");
}
