package ems_controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import emsDao.DeptDao;
import emsDao.EmployeeDAO;
import emsDao.ProjectDAO;
import ems_hibernate.Department;
import ems_hibernate.Employee;
import ems_hibernate.Project;

public class EmsControllar {
	private static Scanner scanner = new Scanner(System.in);
	private static DeptDao departmentDAO = new DeptDao();
	private static EmployeeDAO employeeDAO = new EmployeeDAO();
	private static ProjectDAO projectDAO = new ProjectDAO();

	public static void main(String[] args) {
		while (true) {
			System.out.println("----welcome ----");
			System.out.println("1. nanage Departments");
			System.out.println("2. manage Employees");
			System.out.println("3.manage Projects");
			System.out.println("4. eexit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				manageDepartments();
				break;
			case 2:
				manageEmployees();
				break;
			case 3:
				manageProjects();
				break;
			case 4:
				System.out.println("Exiting the EMS System.");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void manageDepartments() {
		while (true) {
			System.out.println("Department Management");
			System.out.println("1. Add Department");
			System.out.println("2. View Department");
			System.out.println("4. Update Department");
			System.out.println("5. Delete Department");
			System.out.println("6. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addDepartment();
				break;
			case 2:
				viewDepartment();
				break;
			case 4:
				updateDepartment();
				break;
			case 5:
				deleteDepartment();
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void addDepartment() {
		System.out.print("Enter Department Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Department Location: ");
		String location = scanner.nextLine();
		System.out.print("Enter Department Phone Number: ");
		long phoneNumber = scanner.nextLong();
		scanner.nextLine();

		System.out.println("Enter dept id:");
		int id = scanner.nextInt();

		Department department = new Department();
		department.setName(name);
		department.setId(id);
		department.setLocation(location);
		department.setPhoneno(phoneNumber);

		departmentDAO.saveDepartment(department);
		System.out.println("Department added successfully.");
	}

	private static void viewDepartment() {
		System.out.print("Enter Department ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Department department = departmentDAO.getDepartment(id);
		if (department != null) {
			System.out.println("Department ID: " + department.getId());
			System.out.println("Name: " + department.getName());
			System.out.println("Location: " + department.getLocation());
			System.out.println("Phone Number: " + department.getPhoneno());
			System.out.println("Employees: " + department.getEmployees().size());
		} else {
			System.out.println("Department not found.");
		}
	}

	private static void updateDepartment() {
		System.out.print("Enter Department ID to update: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Department department = departmentDAO.getDepartment(id);
		if (department != null) {
			System.out.print("Enter new Name: ");
			String name = scanner.nextLine();
			System.out.print("Enter new Location: ");
			String location = scanner.nextLine();
			System.out.print("Enter new Phone Number: ");
			long phoneNumber = scanner.nextLong();
			scanner.nextLine();

			department.setName(name);
			department.setLocation(location);
			department.setPhoneno(phoneNumber);

			departmentDAO.updateDepartment(department);
			System.out.println("Department updated successfully.");
		} else {
			System.out.println("Department not found.");
		}
	}

	private static void deleteDepartment() {
		System.out.print("Enter Department ID to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		departmentDAO.deleteDepartment(id);
		System.out.println("Department deleted successfully.");
	}

	private static void manageEmployees() {
		while (true) {
			System.out.println("Employee Management");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. View All Employees");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Assign Project to Employee");
			System.out.println("7. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				viewEmployee();
				break;

			case 4:
				updateEmployee();
				break;
			case 5:
				deleteEmployee();
				break;
			case 6:
				assignProjectToEmployee();
				break;
			case 7:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void addEmployee() {

		System.out.print("Enter Employee Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Joining Date (yyyy-MM-dd): ");
		String joiningDate = scanner.nextLine();
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		System.out.println("Enter dept id:");
		int id = scanner.nextInt();

		Employee employee = new Employee();
		employee.setName(name);
		employee.setId(id);
		employee.setJoiningDate(LocalDate.parse(joiningDate, DateTimeFormatter.ISO_LOCAL_DATE));
		employee.setEmail(email);
		employee.setPassword(password);

		employeeDAO.saveEmployee(employee);
		System.out.println("Employee added successfully.");
	}

	private static void viewEmployee() {
		System.out.print("Enter Employee ID: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		Employee employee = employeeDAO.getEmployee(id);
		if (employee != null) {
			System.out.println("Employee ID: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Joining Date: " + employee.getJoiningDate());
			System.out.println("Email: " + employee.getEmail());
			System.out.println("Projects: " + employee.getProjects().size());
		} else {
			System.out.println("Employee not found.");
		}
	}

	private static void updateEmployee() {
		System.out.print("Enter Employee ID to update: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Employee employee = employeeDAO.getEmployee(id);
		if (employee != null) {
			System.out.print("Enter new Name: ");
			String name = scanner.nextLine();
			System.out.print("Enter new Joining Date (yyyy-MM-dd): ");
			String joiningDate = scanner.nextLine();
			System.out.print("Enter new Email: ");
			String email = scanner.nextLine();
			System.out.print("Enter new Password: ");
			String password = scanner.nextLine();

			employee.setName(name);
			employee.setJoiningDate(LocalDate.parse(joiningDate, DateTimeFormatter.ISO_LOCAL_DATE));
			employee.setEmail(email);
			employee.setPassword(password);

			employeeDAO.updateEmployee(employee);
			System.out.println("Employee updated successfully.");
		} else {
			System.out.println("Employee not found.");
		}
	}

	private static void deleteEmployee() {
		System.out.print("Enter Employee ID to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		employeeDAO.deleteEmployee(id);
		System.out.println("Employee deleted successfully.");
	}

	private static void manageProjects() {
		while (true) {
			System.out.println("Project Management");
			System.out.println("1. Add Project");
			System.out.println("2. View Project");
			System.out.println("4. Update Project");
			System.out.println("5. Delete Project");
			System.out.println("6. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addProject();
				break;
			case 2:
				viewProject();
				break;
			case 4:
				updateProject();
				break;
			case 5:
				deleteProject();
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void addProject() {

		System.out.println("Enter project id:");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Project Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Start Date (yyyy-MM-dd): ");
		String startDate = scanner.nextLine();
		System.out.print("Enter Deadline (yyyy-MM-dd): ");
		String deadline = scanner.nextLine();

		Project project = new Project();
		project.setName(name);
		project.setId(id);
		project.setStartDate(LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE));
		project.setDeadline(LocalDate.parse(deadline, DateTimeFormatter.ISO_LOCAL_DATE));

		projectDAO.saveProject(project);
		System.out.println("Project added successfully.");
	}

	private static void viewProject() {
		System.out.print("Enter Project ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Project project = projectDAO.getProject(id);
		if (project != null) {
			System.out.println("Project ID: " + project.getId());
			System.out.println("Name: " + project.getName());
			System.out.println("Start Date: " + project.getStartDate());
			System.out.println("Deadline: " + project.getDeadline());
			System.out.println("Employees: " + project.getEmployees().size());
		} else {
			System.out.println("Project not found.");
		}
	}

	private static void updateProject() {
		System.out.print("Enter Project ID to update: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Project project = projectDAO.getProject(id);
		if (project != null) {
			System.out.print("Enter new Name: ");
			String name = scanner.nextLine();
			System.out.print("Enter new Start Date (yyyy-MM-dd): ");
			String startDate = scanner.nextLine();
			System.out.print("Enter new Deadline (yyyy-MM-dd): ");
			String deadline = scanner.nextLine();

			project.setName(name);
			project.setStartDate(LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE));
			project.setDeadline(LocalDate.parse(deadline, DateTimeFormatter.ISO_LOCAL_DATE));

			projectDAO.updateProject(project);
			System.out.println("Project updated successfully.");
		} else {
			System.out.println("Project not found.");
		}
	}

	private static void deleteProject() {
		System.out.print("Enter Project ID to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		projectDAO.deleteProject(id);
		System.out.println("Project deleted successfully.");
	}

	private static void assignProjectToEmployee() {
		System.out.print("Enter Employee ID: ");
		int employeeId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.print("Enter Project ID: ");
		int projectId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		employeeDAO.assignProjectToEmployee(employeeId, projectId);
	}
}
