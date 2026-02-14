import React, { useState } from "react";

function App() {
  const [show, setShow] = useState(true);

  return (
    <div>
      <button onClick={() => setShow(!show)}>Toggle</button>
      {show && <h2>This text is visible</h2>}
    </div>
  );
}

export default App;
