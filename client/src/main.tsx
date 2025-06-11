import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'

// entry points for react, this is where react renders the app

createRoot(document.getElementById('root')!).render( // '!' asserts that document.getElementById('root') will 100% return a HTMLElement, and not null.
  <StrictMode>
    <App />
  </StrictMode>,
)
