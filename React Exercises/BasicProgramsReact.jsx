function App() {
  return (
    <h1>Hello React!</h1>
  );
}

export default App;


import React, { useState } from 'react';

function App() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <h2>Count: {count}</h2>
      <button onClick={() => setCount(count + 1)}>Increase</button>
      <button onClick={() => setCount(count - 1)}>Decrease</button>
    </div>
  );
}

export default App;


function Student(props) {
  return <h3>Name: {props.name}</h3>;
}

function App() {
  return (
    <div>
      <Student name="Anil" />
      <Student name="Rahul" />
    </div>
  );
}

export default App;


import React, { useState } from 'react';

function App() {
  const [text, setText] = useState("");

  return (
    <div>
      <input
        type="text"
        onChange={(e) => setText(e.target.value)}
      />
      <h3>You typed: {text}</h3>
    </div>
  );
}

export default App;


