# styled-components

- js 안에 css를 작성할 수 있게 해주는 리액트 라이브러리

## 기본 사용 방법

- css를 적용한 컴포넌트를 만들어 바로 사용할 수 있음

```javascript
import styled from "styled-components";

const Box = styled.div`
  width: 20px;
  height: 20px;
  border: 1px solid black;
`;

function App() {
  return <Box />;
}

export default App;
```

## props를 이용하여 동적으로 css를 적용하는 방법

```javascript
import styled from "styled-components";

const Box = styled.div`
  width: 20px;
  height: 20px;
  border: 1px solid black;
  background-color: ${({ color }) => color || "white"};
`;

function App() {
  return <Box color="blue" />;
}

export default App;
```

## 파일 분리를 통해 컴포넌트의 재사용성을 높이는 방법

```javascript
// styledComponents.jsx
import styled from "styled-components";

export const Box = styled.div`
  width: 20px;
  height: 20px;
  border: 1px solid black;
`;
```

```javascript
// App.jsx
import * as t from "./styledComponents";

export default function App() {
  return <t.Box />;
}
```

## 파일 분리 및 props를 활용하여 작성하는 방법

```javascript
// styledComponents.jsx
import styled from "styled-components";

export const Box = styled.div<{ textColor?: string }`
  width: 20px;
  height: 20px;
  border: 1px solid black;
  color: ${({ textColor }) => textColor};
`;
```

```javascript
// App.jsx
import * as t from "./styledComponents";

export default function App() {
  return <t.Box textColor="blue" />;
}
```
