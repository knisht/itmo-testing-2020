import { render, fireEvent } from '@testing-library/vue';
import GuessingGame from "@/pages/Guess/GuessingGame";

test('User can input incorrect answer', async () => {
    const { getByPlaceholderText, getByText } = render(GuessingGame, {
        propsData: {
            game: {sequence: [1, 2, 3], name: "Hello", link: "today", result: 4}
        }
    });

    const inputForm = getByPlaceholderText("Type the number");
    await fireEvent.update(inputForm, '3');

    getByText("No, you're wrong.")
})
