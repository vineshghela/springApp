document
  .getElementById("noteform")
  .addEventListener("submit", function (event) {
    event.preventDefault();
  
    const data = {
      "name": this.noteName.value,
      "description": this.noteDescription.value
    }

    fetch("http://localhost:9000/notes/create", {
      method: "POST",
      headers: {
        "Content-type": " application/json;",
      },
      body: JSON.stringify(data),
    })
      .then(response => response.json())
      .then(function (data) {
        console.log("Request succeeded with JSON response", data);
      })
      .catch(function (error) {
        console.log("Request failed", error);
      });
  });
