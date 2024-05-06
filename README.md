# Library api
# About
## Overview

This library API serves as a comprehensive solution for managing books, readers, and rental operations within a library system. It consists of four main controllers, each handling specific aspects of the library's functionality:

- Reader Controller: Manages operations related to library members or readers, such as adding new readers, updating their information, or retrieving their details.

- BookTitle Controller: Handles operations concerning book titles, including adding new titles to the library's collection, updating existing titles, or retrieving information about specific titles.

- BookCopy Controller: Manages the inventory of book copies available in the library. This controller handles tasks such as adding new copies, updating copy details, or retrieving information about available copies.

- BookRent Controller: Facilitates rental operations, allowing readers to borrow books from the library. This controller handles tasks such as renting books, returning them, or checking the rental status of a particular book.

# Architecture

The API follows a modular architecture, with each controller having its own dedicated service layer. This separation of concerns ensures code maintainability, scalability, and easier testing. The services associated with each controller encapsulate the business logic related to their respective domains, providing a clear and organized structure for development.
Reader Service

The Reader service handles operations related to managing reader information. It includes methods for creating new reader profiles, updating existing profiles, and retrieving reader details.
BookTitle Service

The BookTitle service focuses on managing book titles within the library's collection. It provides functionality for adding new titles, updating title information, and querying title details.
BookCopy Service

The BookCopy service is responsible for managing the inventory of book copies available in the library. It includes methods for adding new copies, updating copy information, and retrieving copy details.
BookRent Service

The BookRent service facilitates rental operations, handling tasks related to borrowing and returning books. It provides methods for renting books, processing returns, and checking the rental status of individual books.
