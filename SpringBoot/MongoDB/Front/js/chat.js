document.getElementById("chat-send").addEventListener("click", () => {
  // alert("클릭");
  let chatBox = document.getElementById("chat-box");
  let chatOutgoingBox = document.createElement("div");
  chatOutgoingBox.innerHTML = "hi";
  chatBox.append(chatOutgoingBox);
});

document
  .getElementById("chat-outgoing-msg")
  .addEventListener("keydown", (e) => {
    if (e.keyCode === 13) {
      alert("enter");
    }
  });
