swagger: "2.0"
info:
  description: "This api gets employee info/details from back end mongo DB and provide it to consumers"
  version: "1.0.0"
  title: "Employee Details API"
  termsOfService: "sample"
  contact:
    email: "lydia_andrews18@yahoo.com"
  license:
    name: "none"
    url: "none"
host: "localhost"
basePath: "/"
tags:
- name: "employeeInfo"
  description: "High level information about the employees"
- name: "emplyeeDetails"
  description: "Detail information about the employees"
- name: "id"
  description: "employee identification number"
schemes:
- "http"
paths:
  /employeeinfo:
    get:
      tags:
      - "employeeinfo"
      summary: "Gets High level information about the employees"
      description: ""
      operationId: "getEmployeeInfo"
      consumes:
      - "application/json"
      produces:
      - "application/json"
      parameters:
      - in: "body"
        name: "body"
        description: "Gets High level information about the employees"
        required: true
      responses:
        200:
          description: "successful operation"
          schema:
            type: "object"
            items:
              $ref: "#/definitions/employeeinfo"
        500:
          description: "Invalid input"
  /employeedetails:
    get:
      tags:
      - "employeedetails"
      summary: "Detail information about the employees"
      description: "Provides Detail information about the employees"
      operationId: "getEmployeeDetail"
      produces:
      - "application/xml"
      - "application/json"
      parameters:
      - name: "id"
        in: "query"
        description: "employee id for getting detail informatioon about individual employee"
        required: true
        collectionFormat: "multi"
      responses:
        200:
          description: "successful operation"
          schema:
            type: "object"
            items:
              $ref: "#/definitions/employeedetails"
        400:
          description: "Invalid status value"
definitions:
  EmployeeDetails:
    type: "object"
    properties:
      id:
        type: "string"
      name:
        type: "string"
      Designation:
        type: "string"
      Salary:
        type: "string"
  EmployeeInfo:
    type: "object"
    properties:
      id:
        type: "string"
      name:
        type: "string"
      hiredate:
        type: "string"
      salary:
        type: "string"
