import http from "http";

const PORT = 3000;

const rotas = {
   "/": (req, res) => {
      res.writeHead(200, { "Content-Type": "text/plain" });
      res.end("Hello World\n");
   },
   "/users": (req, res) => {
      res.writeHead(200, { "Content-Type": "application/json" });
      res.end(JSON.stringify({ users: ["João", "Maria", "José"] }));
   },
};

const server = http.createServer((req, res) => {
   if (rotas[req.url]) {
      rotas[req.url](req, res);
   } else {
      res.writeHead(404, { "Content-Type": "text/plain" });
      res.end("Not Found\n");
   }
});

server.listen(PORT, () => {
   console.log(`Server running at http://localhost:${PORT}/`);
});