import { useState, useEffect } from "react";

function App() {
  const [counter, setValue] = useState(0);
  const [keyword, setKeyword] = useState("");
  const onClick = () => setValue((prev) => prev + 1);
  const onChange = (event) => setKeyword(event.target.value);
  // []안의 값이 바뀔때만 실행하겠다는 뜻
  // []값이 없기 떄문에 1번만 실행
  useEffect(() => {
  console.log("I run only once.");
  }, []);
  // keyword가 바뀔때 마다 실행
  useEffect(() => {
    console.log("I run when 'keyword' changes.")
  }, [keyword]);
  // counter가 바뀔때 마다 실행
  useEffect(() => {
    console.log("I run when 'counter' changes.")
  }, [counter]);
  // 둘다 동시에 감시 또한 가능
  useEffect(() => {
    console.log("I run when keyword && counter changes.")
  }, [keyword, counter]);
  

  return (
    <div>
      <input
        value={keyword}
        onChange={onChange}
        type="text"
        placeholder="Search here..."
      />
      <h1>{counter}</h1>
      <button onClick={onClick}>click me</button>
    </div>
  );
}

export default App;
