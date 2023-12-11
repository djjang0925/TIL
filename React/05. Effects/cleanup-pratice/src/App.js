import { useState, useEffect } from "react";

function Hello() {
  useEffect(() => {
    console.log("hi :)");
    // cleanup function => when you destroying your components you can do something
    // 자주 사용하지는 않음!
    return () => console.log("bye :(");
  }, []);
  return <h1>Hello</h1>;
}

function App() {
  const [showing, setShowing] = useState(false);
  const onClick = () => setShowing((prev) => !prev);
  return (
    <div>
      {/* 코드를 삭제하고 생성하는 방법 */}
      {showing ? <Hello /> : null}
      <button onClick={onClick}>{showing ? "Hide" : "Show"}</button>
    </div>
  );
}

export default App;
