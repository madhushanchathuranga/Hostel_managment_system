
import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import SignInSide from './components/login/SignInSide';
import SignUp from './components/register/SignUp';
function App() {
  return (
    <div className="App">
      <header className="App-header">




        <SignInSide />




      </header>
    </div>
  );
}

export default App;
