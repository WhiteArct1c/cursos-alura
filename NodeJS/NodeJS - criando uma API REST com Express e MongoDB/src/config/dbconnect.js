import mongoose from "mongoose";

async function conectaNaDb(){
   mongoose.connect("mongodb://localhost:27018/api_node_alura");
   return mongoose.connection;
}

export default conectaNaDb;

