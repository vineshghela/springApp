

document
  .querySelector("form.empForm")
  .addEventListener("submit", function (stop) {
    stop.preventDefault();
    let x = document.querySelector("form.empForm").elements;

    let noteNam = x["noteName"].value;
    let noteDesc = x["noteDescription"].value;

    console.log(noteNam);
    console.log(noteDesc);
  
    const data = {
      "name": noteNam,
      "description": noteDesc,
    }

    fetch("http://localhost:9000/notes", {
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
