import express from "express";
import books from "./booksRoutes.js";

const routes = (app)=> {
   app.use(express.json(), books);
};

export default routes;