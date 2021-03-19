const inputField = document.querySelector('.chosen-value');
const dropdown = document.querySelector('.value-list');
const dropdownArray = document.querySelectorAll('.value-list li');
const inputPlaceholder = inputField.placeholder;

let valueArray = [];
dropdownArray.forEach(item => {
  valueArray.push(item.textContent);
});

let closeDropdown = () => {
  dropdown.classList.remove('open');
}

inputField.addEventListener('input', () => {
  dropdown.classList.add('open');
  let inputValue = inputField.value.toLowerCase();
  inputField.value = inputField.value.charAt(0).toUpperCase() + inputField.value.slice(1);
  if (inputValue.length > 0) {
    for (let j = 0; j < valueArray.length; j++) {
      if (!(inputValue.substring(0, inputValue.length) === valueArray[j].substring(0, inputValue.length).toLowerCase())) {
        dropdownArray[j].classList.add('closed');
      } else {
        dropdownArray[j].classList.remove('closed');
      }
    }
  } else {
    for (let i = 0; i < dropdownArray.length; i++) {
      dropdownArray[i].classList.remove('closed');
    }
  }
});

dropdownArray.forEach(item => {
  item.addEventListener('click', (evt) => {
    inputField.value = item.textContent;
    dropdownArray.forEach(dropdown => {
      dropdown.classList.add('closed');
    });
  });
})

inputField.addEventListener('focus', () => {
   inputField.placeholder = 'Type to filter';
   dropdown.classList.add('open');
   dropdownArray.forEach(dropdown => {
     dropdown.classList.remove('closed');
   });
});

inputField.addEventListener('blur', () => {
  inputField.placeholder = inputPlaceholder;
  dropdown.classList.remove('open');
});

document.addEventListener('click', (evt) => {
  const isDropdown = dropdown.contains(evt.target);
  const isInput = inputField.contains(evt.target);
  if (!isDropdown && !isInput) {
    dropdown.classList.remove('open');
  }
});

const inputField1 = document.querySelector('.chosen-value1');
const dropdown1 = document.querySelector('.value-list1');
const dropdownArray1 = document.querySelectorAll('.value-list1 li');
const inputPlaceholder1 = inputField1.placeholder;

let valueArray1 = [];
dropdownArray1.forEach(item => {
  valueArray1.push(item.textContent);
});

let closeDropdown1 = () => {
  dropdown1.classList.remove('open');
}

inputField1.addEventListener('input', () => {
  dropdown1.classList.add('open');
  let inputValue1 = inputField1.value.toLowerCase();
  inputField1.value = inputField1.value.charAt(0).toUpperCase() + inputField1.value.slice(1);
  if (inputValue1.length > 0) {
    for (let j = 0; j < valueArray1.length; j++) {
      if (!(inputValue1.substring(0, inputValue1.length) === valueArray1[j].substring(0, inputValue1.length).toLowerCase())) {
        dropdownArray1[j].classList.add('closed');
      } else {
        dropdownArray1[j].classList.remove('closed');
      }
    }
  } else {
    for (let i = 0; i < dropdownArray1.length; i++) {
      dropdownArray1[i].classList.remove('closed');
    }
  }
});

dropdownArray1.forEach(item => {
  item.addEventListener('click', (evt) => {
    inputField1.value = item.textContent;
    dropdownArray1.forEach(dropdown1 => {
      dropdown1.classList.add('closed');
    });
  });
})

inputField1.addEventListener('focus', () => {
   inputField1.placeholder = 'Type to filter';
   dropdown1.classList.add('open');
   dropdownArray1.forEach(dropdown1 => {
     dropdown1.classList.remove('closed');
   });
});

inputField1.addEventListener('blur', () => {
  inputField1.placeholder = inputPlaceholder1;
  dropdown1.classList.remove('open');
});

document.addEventListener('click', (evt) => {
  const isDropdown1 = dropdown1.contains(evt.target);
  const isInput1 = inputField1.contains(evt.target);
  if (!isDropdown1 && !isInput1) {
    dropdown1.classList.remove('open');
  }
});
