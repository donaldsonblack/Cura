import { useState } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <a href=""><img src="public/plusplus.svg" alt="" /></a>
      </div>
      <h1>Medical Maintenance</h1>
      <div className="card">  
        
        
        <button type="submit" onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>

      </div>
    </>
  )
}

export default App
