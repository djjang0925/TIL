import { useState } from "react";

function App() {
  const [toDo, setToDo] = useState("");
  const [toDos, setToDos] = useState([]);
  const onChange = (event) => setToDo(event.target.value);
  const onSubmit = (event) => {
    event.preventDefault();
    if (toDo === "") {
      return;
    }
    // ...toDos => array to elements
    setToDos((currentArray) => [toDo, ...currentArray]);
    setToDo("");
  };
  const onClick = (event) => {
    setToDos([]);
  };
  console.log(toDos);
  return (
    <div>
      <h1>My To Dos ({toDos.length})</h1>
      <form 
        onSubmit={onSubmit}
        style={{display: "inline"}}
      >
        <input
          onChange={onChange}
          value={toDo}
          type="Text"
          placeholder="Write your to do..."
        />
        <button>Add To Do</button>
      </form>
      <button onClick={onClick}>Reset</button>
      <hr />
      {toDos.map((item, index) => (
        <li key={index}>{item}</li>
      ))}
    </div>
  );
}

export default App;
